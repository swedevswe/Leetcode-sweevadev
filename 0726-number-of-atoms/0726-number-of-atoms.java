class Solution {
    public String countOfAtoms(String formula) {
        //RECURSIVE APPROACH

        //identify elements and counts
        // handle parentheses
        //recursive parsing = to handle nested parentheses effectively
        //combine counts across entire formula
        //format the output
        Map<String, Integer> atomCounts = parseFormula(formula, new int[]{0});
        StringBuilder result = new StringBuilder();
        
        List<String> sortedAtoms = new ArrayList<>(atomCounts.keySet());
        Collections.sort(sortedAtoms);
        
        for (String atom : sortedAtoms) {
            result.append(atom);
            int count = atomCounts.get(atom);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }
    private static Map<String, Integer> parseFormula(String formula, int[] index) {
        Map<String, Integer> atomCounts = new HashMap<>();
        while (index[0] < formula.length() && formula.charAt(index[0]) != ')') {
            if (formula.charAt(index[0]) == '(') {
                index[0]++;
                Map<String, Integer> subCounts = parseFormula(formula, index);
                int count = parseNumber(formula, index);
                for (String atom : subCounts.keySet()) {
                    atomCounts.put(atom, atomCounts.getOrDefault(atom, 0) + subCounts.get(atom) * count);
                }
            } else {
                String atom = parseAtom(formula, index);
                int count = parseNumber(formula, index);
                atomCounts.put(atom, atomCounts.getOrDefault(atom, 0) + count);
            }
        }
        if (index[0] < formula.length() && formula.charAt(index[0]) == ')') {
            index[0]++;
        }
        return atomCounts;
    }
    private static String parseAtom(String formula, int[] index) {
        StringBuilder atom = new StringBuilder();
        atom.append(formula.charAt(index[0]++)); // Upper case letter
        while (index[0] < formula.length() && Character.isLowerCase(formula.charAt(index[0]))) {
            atom.append(formula.charAt(index[0]++));
        }
        return atom.toString();
    }
    private static int parseNumber(String formula, int[] index) {
        int start = index[0];
        while (index[0] < formula.length() && Character.isDigit(formula.charAt(index[0]))) {
            index[0]++;
        }
        if (start == index[0]) {
            return 1; // Default count is 1
        }
        return Integer.parseInt(formula.substring(start, index[0]));
    }
}