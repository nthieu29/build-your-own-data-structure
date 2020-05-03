# build-your-own-data-structure
Building your own data structure.
Inspired by [build-your-own-x](https://github.com/danistefanovic/build-your-own-x) project.
# ![Build your own data structure](images/feynman.png)

## Introduction
This repository is a Maven project and it contains popular and basic data structure implementation and their unit tests:
* Stack
    * Dynamic Array implementation 
    * Linked node implementation
    
        | Implementation        | Push      | Pop   |
        | --------------------- |:---------:| :----:|
        | Dynamic Array         | 1*        | 1*    |
        | Linked Node           | 1         | 1     |
        
        (* = *amortized*)
* Queue
    * Circular Array implementation 
    * Linked node implementation 
    * Priority Queue (Binary Heap implementation)
    
        | Implementation                  | Offer     | Poll  |
        | ------------------------------- |:---------:| :---:|
        | Circular Array                  | 1*        | 1*    |
        | Linked Node                     | 1         | 1     |
        | Priority Queue (Binary Heap)    | logn      | logn  |        
        
        (* = *amortized*)
     
    * Index Min Priority Queue
* Union Find
    * Quick Find 
    * Quick Union (Improved with Weighted and Path Compression)
        | Implementation                    | Union     | isConnected  |
        | --------------------------------- |:---------:| :-----------:|
        | Quick Find                        | n         | 1            |
        | Quick Union (Improved version)    | logn      | logn         |  
        
* Symbol Table
    * Sequential Seach (Linked Node) implementation 
    * Binary Search Tree 
    * 2-3 Tree (Red-Black Tree) 
    * Hash Table
        * Separate Chaining 
        * Linear Probing
        
        | Implementation                    | Get (Worst) | Push (Worst)| Get (Average) | Push (Average)|
        | --------------------------------- |:-----------:| :----------:|:-------------:| :------------:|
        | Sequential Search                 | n           | n           | n             | n             |
        | Binary Search Tree                | n           | n           | logn          | logn          |
        | Red-Black Tree                    | logn        | log         | logn          | logn          |
        | Hash Table (Separate Chaining)    | n           | n           | 1*            | 1*            |
        | Hash Table (Linear Probing)       | n           | n           | 1*            | 1*            |
        
        (* = *uniform hashing assumption*)
        
    * String Symbol Table (Symbol table specialized to string keys)
        * Tries
        * Ternary Search Tries 
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
        * Edge-weighted undirected graph
            * Minimum Spanning Tree
                * Kruskal's Algorithm 
                * Prim's Algorithm
                    * Lazy version (TODO)
                    * Eager version (TODO)
        * Edge-weighted directed graph
            * The shortest path
                * Dijkstra (nonnegative weights)
                * Acyclic Shortest Path - topological sort (no cycles)
                * Bellman–Ford  (no negative cycles)
                
        | Problem                           | Time      | Space        |
        | --------------------------------- |:---------:| :-----------:|
        | DFS                               | E + V     | V            |
        | BFS                               | E + V     | V            |
        | Cycle Detection                   | E + V     | V            |
        | Connected Component               | E + V     | V            |
        | Strong Connected Component        | E + V     | V            |
        | MST (Kruskal)                     | ElogE     | E + V        |
        | Shortest Path (Dijikstra)         | ElogV     | V            |
        | Shortest Path (Topological Sort)  | E + V     | V            |
        | Shortest Path (Bellman-Ford)      | V(E + V)  | V            |
        
        (E = Edge, V = Vertex)
        
* Substring Search
    * Boyer Moore
    * Knuth-Morris-Pratt (TODO)
    * Rabin-Karp (TODO)

## How to use
* Just clone this repository and provide your own data structure implementations to make all tests pass.
* Run test by following command:

        mvn test
    
* When you get stuck, you could refer the provided default implementations. These implementations focus on simplicity and high readability as well as efficient.  
## References
* [Algorithms, 4th Edition](http://amzn.to/13VNJi7) by Robert Sedgewick and Kevin Wayne.
* [algs4](https://github.com/kevin-wayne/algs4) public repo on Github.
