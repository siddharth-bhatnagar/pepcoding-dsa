Dynamic Programming is a method used in mathematics and computer science to solve complex problems by breaking them down into simpler subproblems. By solving each subproblem only once and storing the results, it avoids redundant computations, leading to more efficient solutions for a wide range of problems.

How Does Dynamic Programming (DP) Work?
- Identify Subproblems: Divide the main problem into smaller, independent subproblems.
- Store Solutions: Solve each subproblem and store the solution in a table or array.
- Build Up Solutions: Use the stored solutions to build up the solution to the main problem.
- Avoid Redundancy: By storing solutions, DP ensures that each subproblem is solved only once, reducing computation time.

When to Use Dynamic Programming (DP)?
Dynamic programming is an optimization technique used when solving problems that consists of the following characteristics:

- Optimal Substructure: Optimal substructure means that we combine the optimal results of subproblems to achieve the optimal result of the bigger problem.

- Overlapping Subproblems: The same subproblems are solved repeatedly in different parts of the problem.

Approaches of Dynamic Programming (DP)

- Top-Down Approach (Memoization) -> reqd case to base case
- Bottom-Up Approach (Tabulation) -> base case to reqd case


Approach:
1) Find the recurrence relation and solve using recursion.
2) Then see if there are overlapping subproblems, if yes, then figure out optimal way to store the result