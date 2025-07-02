#include <iostream>
#include <vector>
#include <sstream>
#include <string>

void solve() {
	int n;
	std::cin >> n;
	std::cin.ignore();
	std::string ans;
	std::string name_1;
	std::string name_2;
	for (int i = 0; i < n; i++) {
		std::getline(std::cin, name_2);
		std::getline(std::cin, name_1);
		ans.append("Case ")
			.append(std::to_string(i + 1))
			.append(": ")
			.append(name_1)
			.append(", ")
			.append(name_2)
			.append("\n");
	}

	std::cout << ans;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}