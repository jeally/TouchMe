package com.touchme.model;

import com.touchme.util.Shorty;

import java.io.File;

public class FSobject implements Instance {
	private final String name;
	private final String path;

	public FSobject(String path, String name) {
		this.name = Shorty.avoidNull(name);
		this.path = Shorty.avoidNull(path);
	}

	public FSobject(String path) {
		int index = path.lastIndexOf("/") + 1;
		this.name = Shorty.avoidNull(path.substring(index, path.length()));
		this.path = Shorty.avoidNull(path.substring(0, index));
	}

	/**
	 * @return ex: dir or file
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return ex: /dir1/dir or /dir/file
	 */
	public String getFullPath() {
		return getPath() + getName();
	}

	public File getAsFile() {
		return new File(getFullPath());
	}

	public File getPathAsFile() {
		return new File(path);
	}

	/**
	 * @return ex: /dir1/dir/
	 */
	public String getPath() {
		return path;
	}

	@Override
	public <R> R accept(InstanceVisitor<R> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof FSobject))
			return false;

		FSobject FSobject = (FSobject) o;

		if (!name.equals(FSobject.name))
			return false;
		if (!path.equals(FSobject.path))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + path.hashCode();
		return result;
	}
}
