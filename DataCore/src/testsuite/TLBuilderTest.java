package testsuite;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.GTree;
import datastructures.TreeBuilder;

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
		// Testing a simple tree
		TreeBuilder tBuilder = new TreeBuilder(simpleList);
		GTree gTree = (GTree)tBuilder.build();
		gTree.setVisitOrder(GTree.VisitOrder.pre_order);
		String resultPreorder = gTree.toString();
		System.out.println(resultPreorder);
		gTree.setVisitOrder(GTree.VisitOrder.in_order);
		String resultInorder = gTree.toString();
		System.out.println(resultInorder);
		gTree.setVisitOrder(GTree.VisitOrder.post_order);
		String resultPostorder = gTree.toString();
		System.out.println(resultPostorder);
	}
}
