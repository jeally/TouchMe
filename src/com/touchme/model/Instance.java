package com.touchme.model;

import java.io.Serializable;

public interface Instance extends Serializable {
	<R> R accept(InstanceVisitor<R> visitor);
}
