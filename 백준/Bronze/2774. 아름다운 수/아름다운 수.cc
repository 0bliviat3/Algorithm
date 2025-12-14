#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;
	std::cin >> n;

	std::cin.ignore();

	while (n--) {
		std::string line;
		std::getline(std::cin, line);
		std::vector<bool> used(26, false);
		int distinct_count = 0;
		for (char c : line) {
			if (!used[c - '0']) {
				used[c - '0'] = true;
				distinct_count++;
			}
		}
		std::cout << distinct_count << "\n";
	}


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}