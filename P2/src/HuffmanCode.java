import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * 
 * @author James Patrizi
 * EECS 233 P2
 *Class that constructs full HuffmanTree
 */
public class HuffmanCode {
	
	public HuffmanList tree;
	
	/**
	public HuffmanCode(byte[] b){
		HuffmanList list = new HuffmanList(b);
		while(list.size() > 1){
			HuffmanNode[] lowestTwo = lowestTwo(list);
			HuffmanNode newNode = new HuffmanNode((byte) 0, lowestTwo[0].count + lowestTwo[1].count);
			newNode.left = lowestTwo[0];
			newNode.right = lowestTwo[1];
			list.remove(lowestTwo[0]);
			list.remove(lowestTwo[1]);
			list.add(newNode);
		}
		tree = list;
	}
	**/
	
	public HuffmanCode(byte[] b){
		HuffmanList list = new HuffmanList(b);
		while(list.size() > 1){
			int i = 0;
			HuffmanNode node1 = list.remove(0);
			HuffmanNode node2 = list.remove(0);
			int newCount = node1.count + node2.count;
			HuffmanNode newNode =  new HuffmanNode((byte)-1, newCount);
			newNode.left = node1;
			newNode.right = node2;
			for(int index = 0; i < list.size()-1; index++){
				if(list.get(i).count > newCount){
					list.add(index, newNode);
				}
			}
		}
		this.tree = list;
		traverseAndBuild(tree.getFirst());
	}
	
	
	public HuffmanCode(String file) throws IOException{
		//this(Files.readAllBytes(Paths.get(file)));
		HuffmanList list = new HuffmanList(file);
		while(list.size() > 1){
			int i = 0;
			HuffmanNode node1 = list.remove(0);
			HuffmanNode node2 = list.remove(0);
			int newCount = node1.count + node2.count;
			HuffmanNode newNode =  new HuffmanNode((byte)-1, newCount);
			newNode.left = node1;
			newNode.right = node2;
			for(int index = 0; i < list.size()-1; index++){
				if(list.get(i).count > newCount){
					list.add(index, newNode);
				}
			}
		}
		this.tree = list;
		traverseAndBuild(tree.getFirst());
		
	}
	
	public HuffmanCode(byte[] b , int[] array) throws Exception {
		HuffmanList list = new HuffmanList(b, array);
		while(list.size() > 1){
			int i = 0;
			HuffmanNode node1 = list.remove(0);
			HuffmanNode node2 = list.remove(0);
			int newCount = node1.count + node2.count;
			HuffmanNode newNode =  new HuffmanNode((byte)-1, newCount);
			newNode.left = node1;
			newNode.right = node2;
			for(int index = 0; i < list.size()-1; index++){
				if(list.get(i).count > newCount){
					list.add(index, newNode);
				}
			}
		}
		this.tree = list;
		traverseAndBuild(tree.getFirst());
	}
	
	public boolean[] code(byte b){
		if(traverseAndSearch(tree.getFirst(), b)==null){
			throw new IllegalArgumentException();
		}
		return traverseAndSearch(tree.getFirst(),b).code;
	}
	
	public String codeString(byte b){
		boolean[] unformated = code(b);
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < unformated.length ; i++){
			if(unformated[i] == true){
				sb.append(1);
			}
			
			else{
				sb.append(0);
			}
		}
		return sb.toString();
	}
	
	public String toString(){
		return "eh";
	}
	
	private HuffmanNode traverseAndSearch(HuffmanNode root, Byte b){
		if(root.b == b){
			return root;
		}
		
		if(root.left != null){
			return traverseAndSearch(root.left, b);
		}
		
		if(root.right != null){
			return traverseAndSearch(root.right, b);
		}
		return null;
	}
	
	private void traverseAndBuild(HuffmanNode root){
		LinkedList<Boolean> code = new LinkedList<Boolean>();
		if(root.left != null){
			 code.add(false);
			 traverseAndBuild(root.left);
		}
		
		if(root.right != null){
			code.add(true);
			traverseAndBuild(root.right);
		}
		
		if(root.left == null && root.right == null){
			boolean[] codein = new boolean[code.size()];
			for(int i = 0; i < code.size(); i++ ){
				codein[i] = code.get(i).booleanValue();
			}
			root.code = codein;
		}
	}
	
	
	/**
	private HuffmanNode[] lowestTwo(HuffmanList list){
		HuffmanNode smallest = null;
		HuffmanNode second = null;
		smallest = list.get(0);
		if(list.size() > 1 && list.get(1).count > list.get(0).count)
			second = list.get(1);
		else{
			second = smallest;
			smallest = list.get(1);
		}
		if(list.size() > 2){
			for(int i = 2; i < list.size(); i++){
				if(list.get(i).count < smallest.count){
					second = smallest;
					smallest = list.get(i);
				}
				else if(list.get(i).count < second.count)
					second = list.get(i);
			}
		}	
		return new HuffmanNode[]{smallest, second};
	}
	**/
}

