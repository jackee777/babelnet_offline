# about this program
This is the java offline server. This purpose of this program used together babelnetpy https://github.com/jackee777/babelnetpy.

Maybe, Readme is needed to be revised if I have enough time to check this.

# Java version example
This program is for eclipse. Unfortunately, I cannot write pom.xml, so I cannot change this program for maven.

argument one is a port number. You must setting program arguments(i.e. 1000) in eclipse.

You can check whether your execute is successful or not by accessing http://localhost:1000/getSynsetIds?lemma=mouse.

# Information
This program copy your workspace. The detail information is https://github.com/marcevrard/BabelNet-API.

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

# comment out
#babelnet.restfulurl=http://babelnet.io/v5/service
```

You are now ready to use the API with local indices.

