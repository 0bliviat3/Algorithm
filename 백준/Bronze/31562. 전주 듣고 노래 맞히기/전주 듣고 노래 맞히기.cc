#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

	std::unordered_map<std::string, std::string> map;
	
	int n, m;
	std::cin >> n >> m;
	while (n--) {
		int t;
		std::string song;
		char arr[7] = { 0, };
		std::cin >> t >> song;

		for (int i = 0; i < 7; i++) {
			std::cin >> arr[i];
		}
		std::string key(arr, arr + 3);

		if (map.find(key) == map.end()) {
			map[key] = song;
		} else {
			map[key] = "?";
		}
	}

	while (m--) {
		char arr[3] = { 0, };
		std::cin >> arr[0] >> arr[1] >> arr[2];
		std::string key(arr, arr + 3);

		if (map.find(key) == map.end()) {
			std::cout << "!" << "\n";
		} else {
			std::cout << map[key] << "\n";
		}
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}