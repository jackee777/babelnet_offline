# about this program
This is the java offline server. This purpose of this program used together babelnetpy https://github.com/jackee777/babelnetpy.

Maybe, Readme is needed to be revised if I have enough time to check this.

# Java version example
This program is for eclipse. Unfortunately, I cannot write pom.xml, so I cannot change this program for maven.

Execute babelnet.HttpServer and program argument is a port number. You must setting program arguments(i.e. 1000) in eclipse.

You can check whether your execute is successful or not by accessing http://localhost:1000/getSynsetIds?lemma=mouse.

Get like this.
'''
[{"id":"bn:00277032n","pos":"NOUN","source":"[WIKITR, WIKIDATA, WIKI]"},{"id":"bn:01829516n","pos":"NOUN","source":"[WIKIDATA, WIKIRED, WIKI]"},{"id":"bn:00086020v","pos":"VERB","source":"[WN, OMWN_GAE, MCR_CA, OMWN_SQ, OMWN_FI, OMWN_IT, OMWN_HR, MCR_ES, MCR_EU, OMWN_ID, OMWN_MS, OMWN_JA, OMWN_TH, OMWN_RO, SLOWNET, WIKT, OMWN_AR, WONEF, OMWN_NL, OMWN_EL]"},{"id":"bn:15277358n","pos":"NOUN","source":"[OMWIKI, WIKIRED, WIKIQU, WIKIDATA, WIKI]"},{"id":"bn:01189207n","pos":"NOUN","source":"[WIKIRED, WIKI, WIKIDATA, WIKITR]"},{"id":"bn:00416785n","pos":"NOUN","source":"[WIKIDATA, WIKIRED, WIKITR, WIKI]"},{"id":"bn:15126701n","pos":"NOUN","source":"[OMWIKI, WIKIDATA, WIKIRED, WIKI]"},{"id":"bn:03795748n","pos":"NOUN","source":"[WIKIDATA, WIKIRED, WIKI]"},{"id":"bn:16369318n","pos":"NOUN","source":"[WIKIDATA, WIKI]"},{"id":"bn:02372216n","pos":"NOUN","source":"[WIKIDATA, WIKIRED, WIKI]"},{"id":"bn:03482002n","pos":"NOUN","source":"[WIKI, WIKIRED, WIKIDATA]"},{"id":"bn:00090942v","pos":"VERB","source":"[OMWN_TH, OMWN_FI, OMWN_FR, WN, WONEF, WIKT]"},{"id":"bn:03389543n","pos":"NOUN","source":"[WIKIDATA, WIKI, WIKIRED, BABELNET]"},{"id":"bn:00056120n","pos":"NOUN","source":"[MCR_ES, OMWN_FI, WIKT, SLOWNET, OMWN_NL, OMWN_FA, WN]"},{"id":"bn:00010892n","pos":"NOUN","source":"[OMWN_FR, OMWN_GAE, OMWIKI, OMWN_IT, OMWN_FI, MCR_CA, MCR_ES, MCR_GL, OMWN_NL, WIKIDATA, WIKIRED, OMWN_PT, WIKT, SLOWNET, OMWN_LT, OMWN_SK, WONEF, WIKI, WIKITR, WN, OMWN_TH, OMWN_ZH]"},{"id":"bn:00021487n","pos":"NOUN","source":"[OMWN_ID, OMWN_MS, OMWN_NL, OMWN_FR, MCR_PT, OMWIKI, MCR_EU, OMWN_IT, OMWN_FI, ICEWN, SALDO, OMWN_BG, MCR_CA, MCR_ES, MCR_GL, OMWN_HR, OMWN_PL, OMWN_TH, OMWN_NO, OMWN_ZH, OMWN_NN, OMWN_JA, OMWN_HE, OMWN_DA, OMWN_GAE, MSTERM, WIKIRED, WIKIDATA, WIKI, OMWN_RO, OMWN_PT, SLOWNET, IWN, WIKITR, OMWN_EL, WNTR, WN]"},{"id":"bn:02131263n","pos":"NOUN","source":"[WIKIDATA, WIKIRED, WIKI]"},{"id":"bn:21106247n","pos":"NOUN","source":"[WIKI]"},{"id":"bn:02349769n","pos":"NOUN","source":"[WIKI, WIKIDATA, WIKIRED, WIKIQU, BABELNET]"},{"id":"bn:03092726n","pos":"NOUN","source":"[WIKIDATA, WIKIRED, WIKI, WIKT]"},{"id":"bn:03040109n","pos":"NOUN","source":"[WIKI, WIKIDATA, WIKIRED]"},{"id":"bn:14338157n","pos":"NOUN","source":"[WIKIRED, WIKIDATA, WIKI]"},{"id":"bn:15053146n","pos":"NOUN","source":"[WIKIDATA, WIKIRED, WIKI]"},{"id":"bn:15573305n","pos":"NOUN","source":"[OMWIKI, WIKI, WIKIDATA, WIKIRED, WIKITR, WIKT, BABELNET]"},{"id":"bn:00056119n","pos":"NOUN","source":"[MCR_ES, ICEWN, OMWN_IT, SALDO, OMWN_SQ, MCR_EU, MCR_CA, OMWN_BG, MCR_GL, OMWN_FI, OMWIKI, OMWN_HR, MCR_PT, OMWN_GAE, WIKT, WIKIDATA, WIKIRED, WIKI, WIKITR, SLOWNET, OMWN_AR, OMWN_PT, WIKIQU, WIKIQUREDI, IWN, OMWN_RO, OMWN_NL, OMWN_EL, OMWN_KO, OMWN_MS, OMWN_ID, WNTR, WN, OMWN_FR, OMWN_JA, OMWN_HE, OMWN_NN, OMWN_NO, OMWN_ZH, OMWN_PL, OMWN_TH, OMWN_DA]"}]
'''

# Information
Make your project and copy this program in your project. The detail information is https://github.com/marcevrard/BabelNet-API.

## 1 ECLIPSE SETTING
Setting properties and classpath and so on
```
Create your Eclipse project (File -> New -> Java project, give the project a name and press Finish). This creates a new folder with the project name projectFolder/ under your Eclipse workspace folder.

Copy the config/ and resources/ folders from the BabelNet-API-4.0 folder into your workspace/projectFolder/

Now we need to include all the lib/*.jar files and the babelnet-api-4.0.jar file in the project build classpath:

Select the project from 'Package Explorer' tree view

From the top bar click on 'Project' and then 'Properties'

Once inside the 'Properties' section click on 'Java build path' and select the 'Libraries' tab

From the right menu click on the 'Add External JARs' button

Browse to the downloaded BabelNet-API-4.0 folder, and select all the lib/*.jar files along with the babelnet-api-4.0.jar file

Next we need to include the config/ folder in the project build classpath:

Select the project from 'Package Explorer' tree view

From the top bar click on 'File' and then 'Refresh'

From the 'Java build path' (see point 3 above) select the 'Source' tab

Once in the 'Source' tab, click on 'Add Folder' from the right sidebar and select the downloaded config/ folder
```
Happy coding!! ;-)

For more information consult the guide online, http://babelnet.org/guide


## SETTING SOURCES
### WORDNET
download from https://wordnet.princeton.edu/download/current-version#nix

example is here
```
cd /opt
sudo tar -jxvf /your dir/WordNet-3.0.tar.bz2
```

In "config/babelnet.var.properties"
```
jlt.wordnetPrefix=/opt/WordNet
```

### BABELNET
download from https://babelnet.org/home
example is here 
```
cd 
sudo tar -jxvf /your dir/babelnet-4.0.1-index.tar.bz2
```

In "config/babelnet.var.properties"
```
babelnet.dir=/opt/BabelNet-4.0.1

# maybe, this program does not need your key.
#babelnet.key=

# comment out
#babelnet.restfulurl=http://babelnet.io/v5/service
```

You are now ready to use the API with local indices.

