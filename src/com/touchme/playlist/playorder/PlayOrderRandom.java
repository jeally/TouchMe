package com.touchme.playlist.playorder;

import com.touchme.model.Track;
import com.touchme.persistance.framework.executor.OperationExecutor;
import com.touchme.persistance.framework.sort.RandomOrder;
import com.touchme.persistance.source.sql.First;
import com.touchme.persistance.source.sqlite.QuerySqlite;
import com.touchme.persistance.turtle.db.TurtleDatabase;
import com.touchme.persistance.turtle.db.structure.Tables;
import com.touchme.persistance.turtle.mapping.TrackCreator;
import com.touchme.playlist.Playlist;

public class PlayOrderRandom implements PlayOrderStrategy
{

	private final Playlist playlist;
	private final TurtleDatabase db;

	public PlayOrderRandom(TurtleDatabase db,
								  Playlist playlist)
	{
		this.playlist = playlist;
		this.db = db;
	}

	public Track getNext(Track currTrack)
	{
		return get();
	}

	public Track getPrevious(Track currTrack)
	{
		return get();
	}

	private Track get()
	{
		return OperationExecutor.execute(db,
				  new QuerySqlite<Tables.Tracks, Tables.Tracks, Track>(
							 playlist.getCompressedFilter(),
							 new RandomOrder<Tables.Tracks>(),
							 new First<Track>(Tables.TRACKS, new TrackCreator())));
	}
}
