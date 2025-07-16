#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

void solve() {

	int n;
	std::string ans;
	std::cin >> n;
	std::cin.ignore();
	while (n--) {
		std::string input;
		std::getline(std::cin, input);
		int mid = input.size() >> 1;
		if (input[mid] == input[mid - 1]) {
			ans.append("Do-it\n");
		} else {
			ans.append("Do-it-Not\n");
		}
	}
	
	std::cout << ans;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}