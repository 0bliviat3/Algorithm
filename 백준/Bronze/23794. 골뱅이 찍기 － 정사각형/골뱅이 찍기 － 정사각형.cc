#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

void solve() {

	int n;
	std::string ans;
	std::cin >> n;
	for (int i = 0; i < n + 2; ++i) {
		for (int j = 0; j < n + 2; j++) {
			if (i == 0 || i == n + 1) {
				ans.append("@");
			} else {
				if (j == 0 || j == n + 1) {
					ans.append("@");
				} else {
					ans.append(" ");
				}
			}
		}
		ans.append("\n");
	}

	std::cout << ans;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}