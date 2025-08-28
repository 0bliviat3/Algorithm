#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {
	std::string id;
	std::string word;

	std::vector<bool> alpha(26, false);
	std::cin >> id >> word;

	for (char c : id) {
		alpha[c - 'a'] = true;
	}
	for (char c : word) {
		if (alpha[c - 'a']) {
			continue;
		}
		std::cout << c;
	}
	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}