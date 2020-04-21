const formbst = (preorder) =>{
    const root = new TreeNode(preorder[0]);

    
    if(preorder.length === 1) return root;

    const insertNode = val => {
        const newNode = new TreeNode(val);
        let current = root;
        let parent = root;
        
        while(current !== null) {
            parent = current;
            if(val < current.val) {
                current = current.left;
            } else {
                current = current.right
            }
        }
        
        if(val < parent.val) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    for(let i = 1; i < preorder.length; i++) {
        insertNode(preorder[i])
    }
    return root
}

// es6 solution

const bstFromPreOrder = preorder =>{

    const[root, ...rest] = preorder;
    const rootNode = new TreeNode(root);
    
    rootNode.left = bstFromPreorder(rest.filter(n => n < root))
    rootNode.right = bstFromPreorder(rest.filter(n => n > root))


    return rootNode;
}