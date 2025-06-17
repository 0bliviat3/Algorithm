#include <iostream>

void solve() {
	int n;
	std::string star = "*";
	std::string space = " ";
	std::string ans;
	std::cin >> n;
	for (int i = 1; i < 2 * n; i++) {
		for (int j = 0; j < abs(n - i); j++) {
			ans.append(space);
		}
		for (int j = abs(n - i); j < n; j++) {
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