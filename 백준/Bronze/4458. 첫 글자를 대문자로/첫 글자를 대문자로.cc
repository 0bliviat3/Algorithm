#include <iostream>
#include <vector>
#include <sstream>
#include <string>

void solve() {
	int n;
	std::cin >> n;
	std::cin.ignore();
	std::string ans;
	std::string line;
	while (n--) {
		std::getline(std::cin, line);
		line[0] = toupper(line[0]);
		ans.append(line).append("\n");
	}

	std::cout << ans;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}