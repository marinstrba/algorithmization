class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        Set<String> isInList = new HashSet<>();
        
        for (int i = 0; i < strs.length; ++i)
        {
            if (isInList.contains(strs[i])) continue;
            List<String> innerList = new ArrayList<>();
            for (int j = i + 1; j < strs.length; ++j)
            {
                if (isAnagram(strs[i], strs[j]))
                {
                    innerList.add(strs[j]);
                    isInList.add(strs[j]);
                }
            }
            innerList.add(strs[i]);
            resultList.add(innerList);
      
        }
        return resultList;

    }

    private boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}