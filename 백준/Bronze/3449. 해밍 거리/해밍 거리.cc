#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int n;
	std::cin >> n;
	std::cin.ignore();
	while (n--) {
		std::string a, b;
		std::getline(std::cin, a);
		std::getline(std::cin, b);
		int len = a.length();
		int count = 0;
		for (int i = 0; i < len; ++i) {
			if (a[i] != b[i]) {
				count++;
			}
		}
		std::cout << "Hamming distance is " << count << ".\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}