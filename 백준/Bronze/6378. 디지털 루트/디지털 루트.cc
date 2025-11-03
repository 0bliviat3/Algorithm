#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	while (true) {
		std::string str;
		std::getline(std::cin, str);
		if (str[0] == '0') break;
		int ans = 0;
		for (char c : str) {
			ans += (c - '0');
		}
		if (ans >= 10) {
			int now = ans;
			ans = 0;
			while (true) {
				while (now > 0) {
					ans += now % 10;
					now /= 10;
				}
				if (ans < 10) {
					break;
				}
				now = ans;
				ans = 0;
			}
		}

		std::cout << ans << "\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}