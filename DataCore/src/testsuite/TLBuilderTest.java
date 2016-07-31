package testsuite;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.BSTree;
import datastructures.GTree;
import datastructures.TVLevelOp;
import datastructures.TreeBuilder;
import datastructures.TreeBuilder.TreeType;
import datastructures.TreeVertex;
import datastructures.VertexPathOp;

public class TLBuilderTest {
	private List<String> simpleList = null;
	private List<String> bstList = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		simpleList = DataLoader.LoadData("testdata/tree/simple_tree.txt");
		bstList = DataLoader.LoadData("testdata/tree/binary_search_tree.txt");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// Build trees
		System.out.println("Building a simple tree ...");
		TreeBuilder tBuilder = new TreeBuilder(simpleList, TreeType.generic);
		GTree gTree = (GTree)tBuilder.build();	
		
		// Testing a simple tree for DFS
		System.out.println("Testing pre-order traversal of a simple generic tree ... ");
		gTree.setVisitOrder(GTree.VisitOrder.pre_order);
		String resultPreorder = gTree.toString();
		System.out.println(resultPreorder);
		
		System.out.println("Testing in-order traversal of a simple generic tree ... ");
		gTree.setVisitOrder(GTree.VisitOrder.in_order);
		String resultInorder = gTree.toString();
		System.out.println(resultInorder);
		
		System.out.println("Testing post-order traversal of a simple generic tree ... ");
		gTree.setVisitOrder(GTree.VisitOrder.post_order);
		String resultPostorder = gTree.toString();
		System.out.println(resultPostorder);
		
		// Testing a simple tree for BFS
		System.out.println("Testing BSF level-order traversal of a simple generic tree ... ");
		VertexPathOp vpOp = new VertexPathOp();
		gTree.traverseBFS(vpOp);
		String resultBFS = vpOp.getPath().toString();
		System.out.println(resultBFS);
		
		// Testing tree levels
		System.out.println("Testing retrieval of nodes at the same level of a simple generic tree ... ");
		TVLevelOp tlOp = new TVLevelOp();
		gTree.traverseBFS(tlOp);
		String resultLevels = tlOp.getTreeLevels().toString();
		System.out.println(resultLevels);
		
		System.out.println("Building a binary search tree ...");
		TreeBuilder bstBuilder = new TreeBuilder(bstList, TreeType.bst);
		BSTree bstTree = (BSTree)bstBuilder.build();
		
		System.out.println("Testing in-order traversal of a BST tree ... ");
		bstTree.setVisitOrder(GTree.VisitOrder.in_order);
		String resultBSTInorder = bstTree.toString();
		System.out.println(resultBSTInorder);
		
		System.out.println("Searching for [c] in BST tree ...");
		TreeVertex t1 = bstTree.binarySearch("c");
		System.out.println("Found Vertex with value = " + t1);
		
		System.out.println("Searching for [j] in BST tree ...");
		TreeVertex t11 = bstTree.binarySearch("j");
		System.out.println("Found Vertex with value = " + t11);
	}
}
