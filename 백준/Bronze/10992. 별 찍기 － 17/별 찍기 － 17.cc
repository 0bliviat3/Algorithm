#include <iostream>

void solve() {
	int n;
	std::string star = "*";
	std::string space = " ";
	std::string ans;
	std::cin >> n;

	for (int i = 1; i <= n; ++i) {
		for (int j = n - i; j > 0; j--) {
			ans.append(space);
		}
		for (int j = 1; j <= 2 * i - 1; j++) {
			if (i == 1 || i == n) {
				ans.append(star);
			} else if (j == 1 || j == 2 * i - 1) {
				ans.append(star);
			} else {
				ans.append(space);
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