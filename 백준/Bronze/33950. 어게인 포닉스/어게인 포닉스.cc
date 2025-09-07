#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int n;
	std::cin >> n;
	std::cin.ignore();

	while (n--) {
		std::string input;
		std::getline(std::cin, input);
		size_t pos = 0;
		while ((pos = input.find("PO", pos)) != std::string::npos) {
			input.replace(pos, 2, "PHO");
			pos += 3;
		}
		std::cout << input << "\n";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}