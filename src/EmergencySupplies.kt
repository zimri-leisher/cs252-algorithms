package misc

data class Graph(val edges: List<Edge>, val nodes: List<Node>)

data class Node(val id: Int)

data class Edge(val first: Node, val second: Node, val cost: Int)

fun algo(nodes: List<Node>, graph: Graph): List<Edge>? {
    val sortedEdges = graph.edges.sortedBy { it.cost }

    return null
}

fun main() {
    val graph = Graph(
        listOf(
            Edge(Node(1), Node(2), 8),
            Edge(Node(1), Node(3), 2),
            Edge(Node(3), Node(4), 2),
            Edge(Node(2), Node(4), 2),
            Edge(Node(2), Node(3), 2),
        ),
        listOf(
            Node(1),
            Node(2),
            Node(3),
            Node(4),
        )
    )
    println(algo(listOf(Node(1), Node(4)), graph))
}