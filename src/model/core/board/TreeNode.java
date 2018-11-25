package model.core.board;

import java.util.List;

public abstract class TreeNode<T> implements Iterable<TreeNode> {
    private T content;
    private TreeNode<T> parent;
    private List<TreeNode> children;
}
