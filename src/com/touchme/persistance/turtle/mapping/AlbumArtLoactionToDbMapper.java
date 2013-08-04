package com.touchme.persistance.turtle.mapping;

import android.content.ContentValues;

import com.touchme.model.AlbumArtLocation;
import com.touchme.persistance.source.sql.QueryGeneratorTable;
import com.touchme.persistance.turtle.db.structure.Tables;

/**
 * TURTLE PLAYER
 * <p/>
 * Licensed under MIT & GPL
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 * <p/>
 * More Information @ www.turtle-player.co.uk
 *
 * @author Simon Honegger (Hoene84)
 */

public class AlbumArtLoactionToDbMapper extends QueryGeneratorTable<AlbumArtLocation>
{
	public AlbumArtLoactionToDbMapper()
	{
		super(Tables.ALBUM_ART_LOCATIONS);
	}

	public ContentValues create(AlbumArtLocation albumArtLocation)
	{
		final ContentValues values = new ContentValues();

		values.put(Tables.AlbumArtLocations.PATH.getName(), albumArtLocation.getPath());
		values.put(Tables.AlbumArtLocations.ALBUM_ART_PATH.getName(), albumArtLocation.getAlbumArtpath());

		return  values;
	}
}
