# TF-IDF with MapReduce

- Initial input: folder path with some documents
- Final output: list of (word, doc) ranked by ascending value of TF-IDF

The 4 MapReduce rounds are to be run successively.

The highest scores are at the trail of this output. 

Example for input_docs folder:
```
5.235250603583094E-4	(dave, callwild.txt)
5.671521487215018E-4	(around, callwild.txt)
5.889657130763361E-4	(solleks, callwild.txt)
6.107792370846943E-4	(traces, callwild.txt)
6.107792370846943E-4	(ice, callwild.txt)
6.342635086662482E-4	(thoughts, defoe-robinson-103.txt)
6.544063254478868E-4	(hal, callwild.txt)
6.544063254478868E-4	(team, callwild.txt)
8.071011548922984E-4	(perrault, callwild.txt)
8.72541767263849E-4	(john, callwild.txt)
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
