#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


void solve() {

	int n;
	std::cin >> n;

	std::cin.ignore();
	while (n--) {
		bool alpahbet[26] = { false, };
		std::string str;
		std::getline(std::cin, str);
		for (char c : str) {
			if (c >= 'a' && c <= 'z') {
				alpahbet[c - 'a'] = true;
			}
			else if (c >= 'A' && c <= 'Z') {
				alpahbet[c - 'A'] = true;
			}
		}

		bool isPangram = true;
		std::string missingChars = "";
		for (int i = 0; i < 26; i++) {
			if (!alpahbet[i]) {
				isPangram = false;
				missingChars += (char)('a' + i);
			}
		}
		if (isPangram) {
			std::cout << "pangram\n";
		}
		else {
			std::cout << "missing " << missingChars << "\n";
		}
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}