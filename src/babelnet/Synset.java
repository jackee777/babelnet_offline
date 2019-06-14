package babelnet;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Multimap;

import it.uniroma1.lcl.babelnet.BabelSense;
import it.uniroma1.lcl.babelnet.BabelSynsetType;
import it.uniroma1.lcl.babelnet.WordNetSynsetID;
import it.uniroma1.lcl.babelnet.data.BabelCategory;
import it.uniroma1.lcl.babelnet.data.BabelExample;
import it.uniroma1.lcl.babelnet.data.BabelGloss;
import it.uniroma1.lcl.babelnet.data.BabelImage;
import it.uniroma1.lcl.kb.Domain;

public class Synset {
	List<BabelSense> senses = null;
	List<WordNetSynsetID> wnOffsets = null;
	String mainSense = null;
	List<BabelGloss> glosses = null;
	List<BabelExample> examples = null;
	List<BabelImage> images = null;
	BabelSynsetType synsetType = null;
	List<BabelCategory> categories = null;
	Multimap<BabelSense, BabelSense> translations = null;
	HashMap<Domain, Double> domains = null;
	Set<String> lnToCompound = null;
	Set<String> lnToOtherForm = null;
}
