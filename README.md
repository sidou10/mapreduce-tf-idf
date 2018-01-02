# TF-IDF with MapReduce

Initial input: folder path with some documents
Final output: list of (word, doc) ranked by ascending value of TF-IDF

The 4 MapReduce rounds are to be run successively.

The highest scores are at the trail of this output. 
Example for folder input_docs:
```
8.943553316186832E-4	(trail, callwild.txt)
0.0010228213356125299	(friday, defoe-robinson-103.txt)
0.0010252365563617847	(bucks, callwild.txt)
0.0011343042974430036	(francois, callwild.txt)
0.0013088126508957736	(sled, callwild.txt)
0.0013088126508957736	(spitz, callwild.txt)
0.0016685130239661784	(myself, defoe-robinson-103.txt)
0.0017668970988825323	(thornton, callwild.txt)
0.0024431169483387772	(dogs, callwild.txt)
0.006827639187626952	(buck, callwild.txt)
```
