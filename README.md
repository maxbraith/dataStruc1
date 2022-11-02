# project04-set-griffin-max
project04-set-griffin-max created by GitHub Classroom

-----Why might your data look different than expected? What did you do to try to fix/explain the issue?-----

Intersection and Union made sense for both ListSet and TreeSet as they loop through two Sets meaning that their big-O would be O(n^2). 
ToOrderedList also makes sense as O(n) since you are looping through the list and basically copying and pasting the entire list into an 
Array List and since they’re already in a sorted order, there’s no need to call sort. The size method was one that confused us as it 
should realistically be O(1) for List Set since we only return the Array.length and Array’s know their length within memory meaning that 
the response should be almost instant, however, it ended up being O(n) on the graphs. TreeSet’s size method makes sense since it has to 
loop through every node to count them. Our hypothesis matched the reality. The contains method graphs looked weird, but as discussed in 
class, O(log(n)) graphs can seem weird when doing efficiency tests. Realistically, these graphs should be O(n) since they both use a binary 
search in order to find whether or not an item is contained within the list. Based on the graphs, TreeSet seems more linear with a low slope 
and ListSet seems to follow a log(n) pattern. Lastly, TreeSet’s add method did not seem to match our hypothesis. Its graph seems much more 
linear but thinking about it, this makes sense as it still has to loop through many nodes although there is a bias in our testing. The 
TreeLists that were analyzed were all in order meaning that the tree was in the worst case scenario as nodes were just added to the right.
ListSet’s add method matches our hypothesis as it follows an exponential motion. This is because the sort method is called within the method
so the list is looped through twice.


-----Discuss your findings and note whether, in a practical sense, this implementation difference matters. What real-life data situation would 
this be important for?-----
The contains method seems to be the biggest implementation difference and it definitely matters. A real-life scenario would be for
file systems. Folders are extremely useful for organization purposes and without them, we would have very messy desktops. It makes
no sense to just create a list of files and it is very inefficient and unorganized. It also makes sense to make a binary tree for 
map applications rather than a list.
