#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

    int caseNum = 1;

    while (true) {
        int a, b;
        std::string op;

        std::cin >> a >> op >> b;

        if (op == "E") break;

		bool result = false;

        if (op == ">") {
			result = (a > b);
        } else if (op == ">=") {
			result = (a >= b);
        } else if (op == "<") {
			result = (a < b);
        } else if (op == "<=") {
			result = (a <= b);
        } else if (op == "==") {
			result = (a == b);
        } else if (op == "!=") {
			result = (a != b);
		}

		std::cout << "Case " << caseNum << ": " << (result ? "true" : "false") << "\n";

        caseNum++;
    }

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}