#include <iostream>

void solve() {
	int n, m;
	std::cin >> n;
	std::string ans;
	std::string star = "*";
	std::string space = " ";
	m = n * 2;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (j % 2 == 0) {
				ans.append(star);
			} else {
				ans.append(space);
			}
		}
		std::swap(star, space);
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