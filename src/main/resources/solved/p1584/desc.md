You are given an array points representing integer coordinates of some points on a 2D-plane, where points [i]
= [x<sub>i</sub>, y<sub>i</sub>].

The cost of connecting two points [x<sub>i</sub>, y<sub>i</sub>] and [x<sub>j</sub>, y<sub>j</sub>] is the manhattan
distance between them: |x<sub>i</sub> - x<sub>j</sub>| + |y<sub>i</sub> - y<sub>j</sub>|, where |val| denotes the
absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path
between any two points.

Example 1:  
![img.png](img.png)

```
Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
```

Explanation:  
![img_1.png](img_1.png)  
We can connect the points as shown above to get the minimum cost of 20. Notice that there is a unique path between every
pair of points.

Example 2:

```
Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18
```

Constraints:

- 1 <= points.length <= 1000
- -106 <= x<sub>i</sub>, y<sub>i</sub> <= 106
- All pairs (x<sub>i</sub>, y<sub>i</sub>) are distinct.