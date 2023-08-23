package backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordSearch_II {

	class TrieNode {
		String word;
		Map<Character, TrieNode> children;

		TrieNode() {
			children = new HashMap<>();
		}
	}

	void insertCharToTrie(TrieNode rootNode, String word) {
		TrieNode temp = rootNode;
		for (char ch : word.toCharArray()) {
			if (!temp.children.containsKey(ch)) {
				TrieNode newTrieNode = new TrieNode();
				temp.children.put(ch, newTrieNode);
				temp = newTrieNode;
			} else {
				temp = temp.children.get(ch);
			}
		}
		temp.word = word;
	}

	public List<String> findWords(char[][] board, String[] words) {
		TrieNode rootNode = new TrieNode();
		for (String string : words) {
			insertCharToTrie(rootNode, string);
		}

		List<String> result = new LinkedList<>();
		int rows = board.length, cols = (rows == 0) ? rows : board[0].length;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (rootNode.children.containsKey(board[i][j])) {
					dfs(board, i, j, rows, cols, rootNode, result);
				}
			}
		}
		return result;
	}

	private static void dfs(char[][] board, int row, int col, int rows, int cols, TrieNode root, List<String> result) {
		char currentChar = board[row][col];
		TrieNode currentNode = root.children.get(currentChar);

		if (currentNode.word != null) {
			result.add(currentNode.word);
			currentNode.word = null;
		}

		// mark the current letter before the starting dfs: sort of visited node
		board[row][col] = '*';

		// explore neighbor cells in all 4 directions
		int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int[] direction : directions) {
			int newRow = row + direction[0], newCol = col + direction[1];

			if ((newRow < 0) || (newCol < 0) || (newRow >= rows) || (newCol >= cols)) {
				continue;
			}

			if (currentNode.children.containsKey(board[newRow][newCol])) {
				dfs(board, newRow, newCol, rows, cols, currentNode, result);
			}
		}

		// restore the original letter in the board: sort of remove from visited node
		board[row][col] = currentChar;

		// prune the leaf nodes
		if (currentNode.children.isEmpty()) {
			root.children.remove(currentChar);
		}
	}

}
