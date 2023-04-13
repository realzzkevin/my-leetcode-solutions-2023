class Solution {
    public String simplityPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] subDir = path.split("/");

        for(String dir : subDir) {
            if(dir.isEmpty() || dir.equals(".")){
                continue;
            } else if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.add(dir);
            }
        }

        StringBuilder newPath = new StringBuilder();
        for(String dir : stack){
            newpath.append("/");
            newPath.append(dir);
        }

        return newpath.length() > 0 ? newPath.toString() : "/";
    }
}