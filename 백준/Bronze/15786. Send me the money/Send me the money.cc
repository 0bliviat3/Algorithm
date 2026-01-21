#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	int n, m;
	std::cin >> n >> m;

	std::cin.ignore();
	std::string line;
	std::getline(std::cin, line);

	while (m--) {
		std::string command_line;
		std::getline(std::cin, command_line);
		int idx = 0;
		for (char c : command_line) {
			if (idx >= n) {
				break;
			}
			if (line[idx] == c) {
				++idx;
			}
		}
		if (idx == n) {
			std::cout << "true\n";
		} else {
			std::cout << "false\n";
		}
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}