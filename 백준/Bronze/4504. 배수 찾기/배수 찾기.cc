#include <iostream>
#include <vector>
#include <sstream>
#include <string>

void solve() {
	int n;
	int input;
	std::string ans;
	std::cin >> n;
	
	while (true) {
		std::cin >> input;
		if (input == 0) break;
		ans.append(std::to_string(input));
		if (input % n == 0) {
			ans.append(" is a multiple of ");
		} else {
			ans.append(" is NOT a multiple of ");
		}
		ans.append(std::to_string(n))
			.append(".\n");
	}

	std::cout << ans;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}