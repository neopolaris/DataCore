package testsuite;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.GTree;
import datastructures.TVLevelOp;
import datastructures.TreeBuilder;
import datastructures.VertexPathOp;

public class TLBuilderTest {
	private List<String> simpleList = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		simpleList = DataLoader.LoadData("testdata/tree/simple_tree.txt");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// Build a tree
		TreeBuilder tBuilder = new TreeBuilder(simpleList);
		GTree gTree = (GTree)tBuilder.build();
		
		// Testing a simple tree for DFS
		gTree.setVisitOrder(GTree.VisitOrder.pre_order);
		String resultPreorder = gTree.toString();
		System.out.println(resultPreorder);
		gTree.setVisitOrder(GTree.VisitOrder.in_order);
		String resultInorder = gTree.toString();
		System.out.println(resultInorder);
		gTree.setVisitOrder(GTree.VisitOrder.post_order);
		String resultPostorder = gTree.toString();
		System.out.println(resultPostorder);
		
		// Testing a simple tree for BFS
		VertexPathOp vpOp = new VertexPathOp();
		gTree.traverseBFS(vpOp);
		String resultBFS = vpOp.getPath().toString();
		System.out.println(resultBFS);
		
		// Testing tree levels
		TVLevelOp tlOp = new TVLevelOp();
		gTree.traverseBFS(tlOp);
		String resultLevels = tlOp.getTreeLevels().toString();
		System.out.println(resultLevels);
	}
}
