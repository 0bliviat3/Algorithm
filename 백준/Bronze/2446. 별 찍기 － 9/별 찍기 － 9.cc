#include <iostream>

void solve() {
	int n;
	std::string star = "*";
	std::string space = " ";
	std::string ans;
	std::cin >> n;

	for (int i = -n; i <= n; i++) {
		if (i == 0 || i == 1) {
			continue;
		}
		int abs_i = std::abs(i);
		for (int j = 0; j < n - abs_i; j++) {
			ans.append(space);
		}
		for (int j = 0; j < 2 * abs_i - 1; j++) {
			ans.append(star);
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