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
	
	while(n--) {
		int m;
		char c;
		std::cin >> m >> c;
		while (m--) {
			if (c == 'C') {
				char ch;
				std::cin >> ch;
				std::cout << ch - 'A' + 1 << ' ';
			}
			else {
				int num;
				std::cin >> num;
				std::cout << static_cast<char>('A' + num - 1) << ' ';
			}
		}
		std::cout << '\n';
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}