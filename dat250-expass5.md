# Rapport: DAT250 Experiment 5
<h3>Technical difficulties</h3>
<p>Note: I have some changes to some of the filters of the functions I copied and pasted into my program. For example, instead of finding items = notebook, I might find items = shoe instead. I have done this so none of my operations in the same class overlap with each other. Since all my operations for each CRUD is under the same method, I don't want multiple operations to alter the same item in the document. This way the prints will show what the different operations have done without being overwritten by another operation in the same class.</p>

<p>I did not have a lot of problems with this project, however I did encounter one problem. When attempting to use mapReduce I was told the method was deprecated, and apparently is no longer a recommended method after MongoDB 4.0 (or something like that). So the first time I used it, it messed up my program and I had to invalidate caches and restart my program in order to make anything works again. The next attempt I altered how I handled the output from the method and then it worked.</p>
<p>One thing I found sort of confusing was how you wanted us to download MongoDB. I first used the Homebrew to install it (command-line extension), however this does not give me a simple .tgz fil to test the sha256 sum on. I ended up downloading it using curl and used that to check the sha256 sum. The sum matched which is shown below:</p>

<h3>Screenshots:</h3>
<a>SHA256 checksum:<img src="Screenshots-expass5/SHA256-OK.png"></a>
<a>1. InsertCRUDs:<img src="Screenshots-expass5/InsertSS.png"></a>
<a>2. QueryCRUDs:<img src="Screenshots-expass5/QuerySS.png"></a>
<a>3. UpdateCRUDs:<img src="Screenshots-expass5/UpdateSS.png"></a>
<a>4. DeleteCRUDs:<img src="Screenshots-expass5/DeleteSS.png"></a>
<a>5. BulkWriteCRUDs:<img src="Screenshots-expass5/Bulk-Write-SS.png"></a>
<a>6. MapReduceCRUDs:<img src="Screenshots-expass5/mapReduceSS.png"></a>
<a>7. CustomMapReduceCRUDs:<img src="Screenshots-expass5/customMapReduceSS.png"></a>

<p>The custom Map-reduce method I made creates a list of everyone who has made an order on a given day. It could serve useful if you are a store order and need an overview over previous customers, or if someone has placed an order for a specific day. The collection it outputs is a mapping of dates to customers.</p>