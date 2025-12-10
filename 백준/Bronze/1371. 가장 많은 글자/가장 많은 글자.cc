#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int arr[26] = { 0, };
	while (!(std::cin.eof())) {
		std::string line;
		std::getline(std::cin, line);
		for (char c : line) {
			arr[c - 'a']++;
		}
	}
	int max_count = *std::max_element(arr, arr + 26);
	for (int i = 0; i < 26; i++) {
		if (arr[i] == max_count) {
			std::cout << static_cast<char>(i + 'a');
		}
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}