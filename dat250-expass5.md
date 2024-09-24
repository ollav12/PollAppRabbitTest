# Rapport: DAT250 Experiment 5
<h3>Technical difficulties</h3>
<p>Note: I have some changes to some of the filters of the functions I copied and pasted into my program. For example, instead of finding items = notebook, I might find items = shoe instead. I have done this so none of my operations in the same class overlap with each other. Since all my operations for each CRUD is under the same method, I don't want multiple operations to alter the same item in the document. This way the prints will show what the different operations have done without being overwritten by another operation in the same class.</p>

<p>I did not have a lot of problems with this project, however I did encounter one problem. When attempting to use mapReduce I was told the method was deprecated, and apparently is no longer a recommended method after MongoDB 4.0 (or something like that). So the first time I used it, it messed up my program and I had to invalidate caches and restart my program in order to make anything works again. The next attempt I altered how I handled the output from the method and then it worked.</p>
<p>One thing I found sort of confusing was how you wanted us to download MongoDB. I first used the Homebrew to install it (command-line extension), however this does not give me a simple .tgz fil to test the sha256 sum on. I ended up downloading it using curl and used that to check the sha256 sum. The sum matched which is shown below:</p>

<h3>Screenshots:</h3>
<p>SHA256 Checksum OK:<br><img width="628" alt="SHA256-OK" src="https://github.com/user-attachments/assets/0fe93366-c406-446c-b173-7432ea20be86"></p>
<p>InsertCRUDs:<br><img width="1141" alt="InsertSS" src="https://github.com/user-attachments/assets/109a5837-4ee4-4d80-8565-a5ce601546a7"></p>
<p>QueryCRUDs:<br><img width="1096" alt="QuerySS" src="https://github.com/user-attachments/assets/5ea8b7d4-d667-494a-8361-c2ead378d52d">
</p>
<p>UpdateCRUDs:<br><img width="1313" alt="UpdateSS" src="https://github.com/user-attachments/assets/efa09781-a4e7-4281-93f6-6201bd3b6eae">
</p>
<p>DeleteCRUDs:<br><img width="1106" alt="DeleteSS" src="https://github.com/user-attachments/assets/8eb2fa62-299d-4f96-b065-0c474e89714e">
</p>
<p>BulkWriteCRUDs:<br><<img width="1106" alt="Bulk-Write-SS" src="https://github.com/user-attachments/assets/d23a29a2-054e-4fdd-a797-9b18725f4720">
/p>
<p>MapReduceCRUDs:<br><img width="584" alt="mapReduceSS" src="https://github.com/user-attachments/assets/af633dfd-a7db-4d66-9a79-92fbcd1309fa">
</p>
<p>CustomMapReduceCRUDs:<br><img width="584" alt="customMapReduceSS" src="https://github.com/user-attachments/assets/45eff3c4-cb16-4cab-86df-b057f3a0bf51">
</p>

<p>The custom Map-reduce method I made creates a list of everyone who has made an order on a given day. It could serve useful if you are a store order and need an overview over previous customers, or if someone has placed an order for a specific day. The collection it outputs is a mapping of dates to customers.</p>
