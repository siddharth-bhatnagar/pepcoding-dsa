// Leetcode 165
// O(MAX(M,N)) time, O(MAX(M, N))

class Solution {
    public int compareVersion(String version1, String version2) {
        int start1 = 0, start2 = 0;
        int size1 = version1.length(), size2 = version2.length();

        int rev1, rev2;

        while (start1 < size1 || start2 < size2) {
            int[] info1 = getRevision(version1, start1, size1);
            int[] info2 = getRevision(version2, start2, size2);

            rev1 = info1[0];
            rev2 = info2[0];

            start1 = info1[1];
            start2 = info2[1];

            if (rev1 != rev2) {
                return rev1 > rev2 ? 1 : -1;
            }
        }

        return 0;
    }

    private int[] getRevision(String version, int start, int size) {
        if (start >= size)
            return new int[] { 0, start };

        int idx = start;
        while (idx < size && version.charAt(idx) != '.')
            idx++;

        int num = Integer.parseInt(version.substring(start, idx));

        start = idx + 1;
        return new int[] { num, start };
    }
}