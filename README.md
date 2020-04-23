# build-your-own-data-structure
Building your own data structure.
Inspired by [build-your-own-x](https://github.com/danistefanovic/build-your-own-x) project.
# ![Build your own data structure](images/feynman.png)

## Introduction
This repository is a Maven project and it contains popular and basic data structure implementation and their unit tests:
* Stack
    * Array implementation 
    * Linked node implementation 
* Queue
    * Array implementation 
    * Linked node implementation 
    * Priority Queue (Binary Heap implementation) 
* Union Find
    * Quick Find 
    * Quick Union 
* Symbol Table
    * Sequential Seach (Linked Node) implementation 
    * Binary Search Tree 
    * 2-3 Tree (Red-Black Tree) 
    * Hash Table
        * Separate Chaining 
        * Linear Probing 
* Graph
    * Undirected Graph 
        * DFS 
        * BFS 
        * Cycle Detection 
        * Connected Component 
    * Directed Graph
        * DFS 
        * BFS 
        * Cycle Detection 
        * Strong Connected Component 
    * Edge-weighted graph
        * Minimum Spanning Tree
            * Kruskal's Algorithm 
            * Prim's Algorithm
                * Lazy version (TODO)
                * Eager version (TODO)

## How to use
* Just clone this repository and provide your own data structure implementations to make all tests pass.
* Run test by following command:

        mvn test
    
* When you get stuck, you could refer the provided default implementations. These implementations focus on simplicity and high readability as well as efficient.  
## References
* [Algorithms, 4th Edition](http://amzn.to/13VNJi7) by Robert Sedgewick and Kevin Wayne.
* [algs4](https://github.com/kevin-wayne/algs4) public repo on Github.