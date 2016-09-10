package net.ddns.dustriel.engines.music;

import java.util.List;

import net.ddns.dustriel.model.music.MusicSearchResult;

/**
 * The contract to which 'music' APIs have to adhere to be usable by our Gop Gup system.
 */
public interface MusicFinder {

    List<MusicSearchResult> listAllMatchesWithShortDetails(String albumSearch);
}
