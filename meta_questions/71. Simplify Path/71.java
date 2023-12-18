class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] directories = path.split("/");

        for(String dir : directories) {
            // if dir equals . or "" do nothing
            if(dir.equals(".") || dir.equals("")) continue;
            // if dir == ".." go 1 dir up meaning pop 1 dir from stack
            else if(dir.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.add(dir);
        }

        StringBuilder ans = new StringBuilder();
        // iterate over stack, this loop will go from bottom to up
        for(String dir : stack) {
            ans.append('/');
            ans.append(dir);
        }

        return ans.length() == 0 ? "/" : ans.toString();
    }
}
