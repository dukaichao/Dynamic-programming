package partition07_29;

import java.util.*;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * User:Mr.Du
 * Date:2019/7/29
 * Time:23:49
 */
public class Partition {
    List<List<String>>list=new ArrayList<>();
    String s;
    public List<List<String>> partition(String s) {
        //从头到尾递归+回溯。
        this.s=s;
        //这个是满足的每一个集合
        List<String>ll=new ArrayList<>();
        dfs(ll,0);
        return list;
    }
    public void dfs(List<String>ll,int index){
        if(index==s.length())
        {
            list.add(new ArrayList<>(ll));
            return;
        }
        //i从index开始是因为单个字符也是回文子串
        for(int i=index;i<s.length();i++)
        {
            //如果是回文
            if(isPalindrome(index,i)){

                //把当前的回文子串s(index,i)加进去
                ll.add(s.substring(index,i+1));
                dfs(ll,i+1);
                //把加进去的回文子串去处。和上面加进去的回文子串是同一个回文子串。
                ll.remove(ll.size()-1);
            }

        }
    }
    public boolean isPalindrome(int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

