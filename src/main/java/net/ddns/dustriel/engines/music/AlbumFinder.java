package net.ddns.dustriel.engines.music;

import java.util.List;

import net.ddns.dustriel.engines.Finder;
import net.ddns.dustriel.model.album.AlbumSearchResult;

/**
 * The contract to which 'album' APIs have to adhere to be usable by our Gop Gup system.
 */
public interface AlbumFinder extends Finder {

    List<AlbumSearchResult> listAllMatchesWithShortDetails(String albumTitle);
}
