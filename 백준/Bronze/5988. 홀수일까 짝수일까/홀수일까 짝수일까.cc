#include <iostream>
#include <vector>
#include <sstream>
#include <string>

void solve() {
	int n;
	std::string val;
	std::string ans;
	std::cin >> n;
	std::cin.ignore();
	while (n--) {
		std::getline(std::cin, val);

		char last_number = val[std::size(val) - 1] - '0';
		if (last_number % 2 == 0) {
			ans.append("even");
		} else {
			ans.append("odd");
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