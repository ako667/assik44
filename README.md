# DAG Analysis Project

## Project Overview

This project analyzes **Directed Acyclic Graphs (DAGs)** and includes the following features:

- Detection of **Strongly Connected Components (SCCs)**.
- Topological sorting of the graph.
- Finding **Shortest Paths** from a given source node.
- Finding **Longest Paths (Critical Paths)** from a given source node.
- Reconstruction of paths for clear output.

Graphs are provided in JSON format, where edges include weights.

---

## Key Functionalities and Completion Criteria

- **SCC Detection** ✅
  - The algorithm identifies all strongly connected components in the graph.
  - Output format: list of components, each as a list of nodes.

- **Topological Sorting** ✅
  - DAG is topologically sorted based on SCCs.
  - Output format: a list of nodes in topological order.

- **Shortest Paths** ✅
  - Computes shortest paths from a given source node using DAG-friendly algorithms.
  - Output format: distances and reconstructed paths for each node.

- **Longest Paths / Critical Paths** ✅
  - Computes longest paths (critical paths) from a given source node.
  - Output format: distances and reconstructed paths for each node.

- **Path Reconstruction** ✅
  - Both shortest and longest paths can be reconstructed from predecessor information.
  - Output example: `[0, 1, 2, 3]`.

- **Processing Multiple Graph Files** ✅
  - Handles multiple JSON input files automatically.

- **Validation** ✅
  - All computed paths match expected distances.
  - Topological order is consistent with DAG constraints.

---

## Input JSON Format

Each graph is represented as a list of edges:

```json
[
  {"from": 0, "to": 1, "weight": 2},
  {"from": 1, "to": 2, "weight": 3},
  {"from": 2, "to": 3, "weight": 1}
]
Example Output
text
Копировать код
=== Processing data/small1.json ===
Strongly connected components:
[3]
[2]
[1]
[0]
Topological order:
[0, 1, 2, 3]
Shortest paths from 0:
0 -> 0.0
1 -> 2.0
2 -> 5.0
3 -> 6.0
Shortest paths reconstructed:
[0]
[0, 1]
[0, 1, 2]
[0, 1, 2, 3]
Longest paths from 0 (critical paths):
0 -> 0.0
1 -> 2.0
2 -> 5.0
3 -> 6.0
Longest paths reconstructed:
[0]
[0, 1]
[0, 1, 2]
[0, 1, 2, 3]
Completion Status
SCC detection: ✅ Completed

Topological sorting: ✅ Completed

Shortest paths: ✅ Completed

Longest paths (critical paths): ✅ Completed

Path reconstruction: ✅ Completed

Multiple graph processing: ✅ Completed

Output validation: ✅ Completed
