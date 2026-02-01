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

	std::string line;
	std::cin.ignore();
	std::getline(std::cin, line);

	char prev = '\0';

	std::string ans = "";

	for (char c : line) {
		if (c == 'P') {
			prev = 'P';
			ans += 'P';
		} else if (prev == 'P' && c == 'S') {
			prev = 'S';
			ans += 'S';
		} else if (prev == 'S' && (c == '4' || c == '5')) {
			continue;
		} else {
			prev = '\0';
			ans += c;
		}
	}

	std::cout << ans << "\n";

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}